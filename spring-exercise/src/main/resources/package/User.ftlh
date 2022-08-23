<!DOCTYPE html>
<html lang="en">
<head>
    <title>APACHE FREEMARKER</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div id="filter">
    <input type="text"  name="filtertext">
    <input type="submit" value="Ara" name="filterbtn" id="filter-button">
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
          <tr>
              <td>${user.firstName}</td>
              <td>${user.lastName}</td>
              <td>${user.age}</td>
              <td>${user.gender}</td>
          </tr>
      </#list>
    </tbody>
</table>
<style>
    .container {
        width: 500px;
        height: 250px;
        border: 1px solid black;
        margin:0px;
        padding:0px;
    }

    .data {
        height: 30px;
        margin-left: 20px;


    }
    table {
        margin-top: 50px;

    }
    #filter{
        width: 100px;
        height: 35px;

    }


</style>



<script type="text/javascript">

    const form = document.getElementById('form');
    const buttonFilter=document.getElementById('filter-button');
    /*  var data={
          userName:document.getElementById('username').textContent,
          email:document.getElementById('email').textContent,
          sifre:document.getElementById('sire').textContent
      }*/
/*    form.addEventListener('submit', function (e) {
        console.log("Deneme");
        e.preventDefault();

        var TextuserName = document.getElementById
        ('userName').value;
        var Textemail = document.getElementById
        ('email').value;
        var Textsifre = document.getElementById
        ('sifre').value;

        /!*  formData = new FormData(document.getElementById('registerForm'));*!/

        fetch("http://localhost:8081/users/register", {
            method: 'post',
            body: JSON.stringify({
                "userName": TextuserName,
                "email": Textemail,
                "password": Textsifre
            }),
            headers: {
                "Content-Type": "application/json;  charset=UTF-8"
            }
        }).then(function (response) {
            return response.json()
        }).then(function (data) {
            console.log(data)
        })
    })*/
    buttonFilter.addEventListener('click' , function (e){
        console.log("Deneme");
        e.preventDefault();

        var textFilter=document.getElementById('filter').value;

        fetch("http://localhost:8081/worker/filter", {
            method: 'post',
            body: JSON.stringify({
                "firstName":textFilter
            }),
            headers: {
                "Content-Type": "application/json;  charset=UTF-8",
                "Access-Control-Allow-Methods ": "POST, PUT, PATCH, GET, DELETE, OPTIONS",
                "Access-Control-Allow-Headers ": "Origin, X-Api-Key, X-Requested-With, Content-Type, Accept, Authorization"


    }
        }).then(function (response) {
            return response.json()
        }).then(function (data) {
            console.log(data)
        })
    });

</script>

</body>
</html>