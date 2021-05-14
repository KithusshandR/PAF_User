$.getJSON("http://localhost:8000/getUser", function(userData){
        var responseObj = JSON.parse(JSON.stringify(userData));

        $.each(responseObj,function(i,product){
          appendToUserTable(product);
      });

});

function appendToUserTable(user) {
    
    $("#userTable > tbody:last-child").append(`
          <tr id="user-${user.id}">
              <td class="userData" name="id">${user.id}</td>
              '<td class="userData" name="product_code">${user.name}</td>
              '<td class="userData" name="product_name">${user.email}</td>
              '<td class="userData" name="contributors">${user.phoneNo}</td>
              '<td class="userData" name="email">${user.password}</td>
              '<td align="center">
                  <button class="btn btn-success form-control" onClick="editUser(${user.id})" data-toggle="modal" data-target="#myModal")">EDIT</button>
              </td>
              <td align="center">
                  <button class="btn btn-danger form-control" onClick="deleteUser(${user.id})">DELETE</button>
              </td>
          </tr>
      `)
};



$("form").submit(function(e) {
    e.preventDefault();
});

$("form#addUser").submit(function() {
    var user = {};
    var name = $('input[name="name"]').val().trim();
    var email = $('input[name="email"]').val().trim();
    var phoneNo = $('input[name="phoneNo"]').val().trim();
    var password = $('input[name="password"]').val().trim();

    if(name && email && phoneNo && password){
        $(this).serializeArray().map(function(data) {
            user[data.name] = data.value;
        });

        console.log(user);
        addUser(user)
          
    }else{
        alert("You must have filled all fields");
    }
    
});

function addUser(user){
  $.ajax({
    async:true,
    type:"POST",
    url:"http://localhost:8000/addUser",
    data:JSON.stringify({ user }),
    contentType: 'application/json',
  });
}



function editUser(id) {
    $.getJSON("http://localhost:8000/getUser", function(userData){
          var responseObj = JSON.parse(JSON.stringify(userData));
          responseObj.forEach(function(user, i) {
            if (user.id == id) {
              $(".modal-body").empty().append(`
                        <form id="updateUser" action="">
                            <label for="name">Name</label>
                            <input class="form-control" type="text" name="name" value="${user.name}"/>
                            <label for="email">Email</label>
                            <input class="form-control" type="text" name="email" value="${user.email}"/>
                            <label for="phoneNo">Phone number</label>
                            <input class="form-control" type="text" name="Contributors" value="${user.phoneNo}"/>
                            <label for="password">Password</label>
                            <input class="form-control" type="text" name="password" value="${user.password}"/>
              `);
              $(".modal-footer").empty().append(`
                            <button type="button" type="submit" class="btn btn-primary" data-dismiss="modal" onClick="updateUser(${id})">Save changes</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </form>
              `);
            }
          });
    });
      
}

function updateUser(id) {
    var user2 = {};
    user2.id = id;

    $("#updateUser").children("input").each(function(){
      user2[$(this).attr("name")] = $(this).val();
    })
    console.log(user2);

    $.ajax({
      async:true,
      type:"PUT",
      url:"http://localhost:8000/update",
      data:JSON.stringify({ user2 }),
      contentType: 'application/json',
      success:function(){
        alert("success")
      }
    });
}

function deleteUser(id){
  $.ajax({
    type:"DELETE",
    url:"http://localhost:8000/deleteuser",
    data:`<userData><id>${id}</id></userData>`,
    contentType: 'text/xml',
  });
}
