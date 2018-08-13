package com.restful;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 本控制器类解决类2个问题
 * 1、restTemplate请求接口之后返回的数据为空【返回空是因为使用类 JDK自带的 JSONObject类】
 * 2、restTemplate get请求 设置参数、头部信息 请求失败【请求失败 是因为 url参数拼接方式错误】
 * @author kenshin
 * @date 2018/7/5 下午4:43
 */
@SuppressWarnings("ALL")
@RestController
public class RestfulController {

    //获取token
    private static final String URL_GET_TOKEN = "http://sjgx.gyfc.net.cn:8026/token";

    //添加实名人员信息
    private static final String URL_REALNAMEADD = "http://sjgx.gyfc.net.cn:8026/api/oauth2/RealNameAdd";


    //利用rest 调用接口
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /***
     * 这里的token是从测试服务器地址中获取的 用于相关需要token的接口「有效期为一天」
     * @return
     */
    @GetMapping("/getToken")
    public Object getToken() {

        try {

//            下面的方法也是可以调通接口的
//            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//            map.add("client_id", "2018041200011");
//            map.add("client_secret", "a7a20785-1ec8-4ec3-bc22-9e6da9cdbbfb1");
//            map.add("grant_type", "client_credentials");
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Type", "application/x-www-form-urlencoded");
//            HttpEntity<MultiValueMap<String, Object>> r = new HttpEntity<>(map, headers);
//
//
//            JSONObject jsonResult = restTemplate.postForObject("http://sjgx.gyfc.net.cn:8026/token", r, JSONObject.class);
//            String token = jsonResult.getString("access_token");
//            return jsonResult;

            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            map.add("client_id", "2018041200011");
            map.add("client_secret", "a7a20785-1ec8-4ec3-bc22-9e6da9cdbbfb1");
            map.add("grant_type", "client_credentials");

            //注意：

            //1
            //这里使用的JSONObject是来自 阿里巴巴的 fastJson库，而JDK中本身也有一个同名的库
            //这里如果用JDK中的JSONObject 将无法解析返回的数据
            //在不知道使用什么类来进行解析响应数据时 可以使用Object
            //这里如果用JDK中的JSONObject进行解析 将会得到一个空json   如 "{}"

            //2
            //这里使用restTemplate请求的json参数 必须放在MultiValueMap，而不能使用HashMap 否者请求也会失败

            JSONObject jsonResult = restTemplate.postForObject(URL_GET_TOKEN, map, com.alibaba.fastjson.JSONObject.class);
            String token = jsonResult.getString("access_token");
            return token;

//            这个本地的接口可以测试通 上面的接口测试不通->已解决
//            String hehe = restTemplate.postForObject("http://localhost:8080/kenshin/content", null, String.class);
//            return hehe;

        } catch (Exception e) {
            e.printStackTrace();
            return "请求token失败";
        }
    }


    /***
     * 注意：这里的get请求 带有参数 和 头部信息， 这里使用了 UriComponentsBuilder 来拼接参数，exchange方法来发送请求
     * 如果使用其他方式代码会相当恶心，因为get方法需要将参数拼写在url中 参考自：https://blog.csdn.net/wokenshin/article/details/80971115
     * @return
     * @throws Exception
     */
    @GetMapping("/addRealNameUserInfo")
    public Object test()throws Exception{


        //这里的 token 从 本类的 /getToken 接口中获取「有效期为一天」
        String token = "o86xwToroWg5SyBz9ElhcX5WLiqicsJQOZX_8TJ37VKtMIlkUfJlC2sEUmJZj0s5RZpzxIZMzHzCFBsu2E7NLO9RYOMgDwDUIqNlQPLQ0b2" +
                       "42LJETIIeKva6asKlAltPo-O3tpgyJrXrfhAs5IQOkaeKJXVNpU8BylHRSInfSvW7I6Bw0DoCyhQxsrnA2ax8EgUuPgS_nxBG8dDiuf9y6Q";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_REALNAMEADD)
                .queryParam("name", "李狗蛋")
                .queryParam("idcard", "522121199002100833")
                .queryParam("phone", "18385099999")
                .queryParam("sex", "男")
                .queryParam("national", "中国")
                .queryParam("birthday", "199002190")
                .queryParam("address", "贵州省贵阳市高新区管委会")
                .queryParam("issuance", "1")
                .queryParam("effective", "")
                .queryParam("effective_end", "")
                .queryParam("front_photo", "")
                .queryParam("back_photo", "")
                .queryParam("scene_photo", "18385099999")
                .queryParam("card_type", "身份证")
                .queryParam("mopenid", "2100222222");

        //头部信息
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

        System.out.println("可以看出这里还是将url进行了拼接，毕竟get请求的参数就是方在url里面的");
        System.out.println(builder.build().toUri().toString());

        try{

            ResponseEntity<JSONObject> jsonObjectResult = restTemplate.exchange(builder.build().encode().toUri(),
                    HttpMethod.GET,
                    requestEntity,
                    JSONObject.class);

            return jsonObjectResult;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "闯倒鬼喔";
    }

}
























