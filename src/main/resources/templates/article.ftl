<html>
<head>
    <title>Article</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div>
        <h1>${article.title}</h1>
        <table>
            <tr>
                <th>글번호</th>
                <td>${article.id}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${article.title}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${article.author}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${article.body}</td>
            </tr>
        </table>
    </div>
</body>
</html>