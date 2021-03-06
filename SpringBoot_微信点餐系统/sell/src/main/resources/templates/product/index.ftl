<html>

    <#include "../common/header.ftl">

<body>

<div id="wrapper" class="toggled">
<#--左边侧边栏 sidebar 通过下面的标签将指定文件下的内容包含了进来-->
        <#include "../common/nav.ftl">

<#--主要内容区域 content-->
    <div id="page-content-wrapper">
        <div class="container-fulid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">

                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" class="form-control" type="text" value="${(productInfo.productName)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" class="form-control" type="text" value="${(productInfo.productPrice)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" class="form-control" type="number" value="${(productInfo.productStock)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" class="form-control" type="text" value="${(productInfo.productDescription)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>图片</label>
                            <img width="200" height="200" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" class="form-control" type="text" value="${(productInfo.productIcon)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list  productCategoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                            >
                                        ${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!""}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>

</html>
