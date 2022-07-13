<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator</title>
    <meta charset="UTF-8">
</head>
<body>
    <div>
        <h3>${restaurant.getName()}</h3>
        <h4>Rating: ${restaurant.getRating()}</h4>
        <h4>Category: ${restaurant.getCategoryName()}</h4>
    </div>
    <form method="POST">
        <label for="image">Image:</label>
        <input type="file" id="image" name="image"
               accept="image/png, image/jpeg" value="${restaurant.getImageUrl()}">

        <label for="address">Address: </label>
        <input type="text" id="address" name="address" value="${restaurant.getAddress()}">

        <label for="capacity">Capacity: </label>
        <input type="number" id="capacity" name="capacity" value="${restaurant.getCapacity()}">

        <input type="submit" value="Save">
    </form>

</body>
</html>
