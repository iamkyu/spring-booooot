<html>
<head>
    <title>Article</title>
</head>
<body>
    <div>
        <h1>글쓰기</h1>
        <form action="/article" method="post">
            <table>
                <tr>
                    <th>글번호</th>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="author"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><input type="text" name="body"></td>
                </tr>
            </table>
            <div><input type="submit"></div>
        </form>
    </div>
</body>
</html>