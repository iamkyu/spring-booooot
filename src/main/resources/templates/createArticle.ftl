<html>
<head>
    <title>Article</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<style>
</style>
<body>
    <div>
        <h1>write</h1>
        <form action="/article/create" method="post">
            <table>
                <tr>
                    <th>NO</th>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <th>TITLE</th>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <th>AUTHOR</th>
                    <td><input type="text" name="author"></td>
                </tr>
                <tr>
                    <th>BODY</th>
                    <td>
                        <textarea name="body"></textarea>
                    </td>
                </tr>
            </table>
            <div><input type="submit"></div>
        </form>
    </div>
</body>
</html>