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
                    <form role="form" method="post" action="/sell/seller/category/save">

                        <div class="form-group">
                            <label>名字</label>
                            <input name="categoryName" class="form-control" type="text" value="${(category.categoryName)!""}"/>
                        </div>

                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" class="form-control" type="number" value="${(category.categoryType)!""}"/>
                        </div>

                        <input hidden name="categoryId" type="text" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>

                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>

</html>
