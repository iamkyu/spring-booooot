<html>
<head>
    <title>Article</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div>
    <h1>list</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>TITLE</th>
            <th>AUTHOR</th>
            <th>CREATED</th>
        </tr>
    <#list articles as article>
        <tr>
            <th>${article.id}</th>
            <th style="width: 50%">
                <a href="/article/${article.id}">${article.title}</a>
            </th>
            <th>${article.author}</th>
            <th>${article.created}</th>
        </tr>
    </#list>
    </table>

    <div class="pagination">
    <#list beginIndex..endIndex?number as i>
    <a href="/article/list?page=${i}" <#if currentIndex == i>class = 'active'</#if>>${i}</a>
    </#list>
    </div>
</div>
</body>
</html>