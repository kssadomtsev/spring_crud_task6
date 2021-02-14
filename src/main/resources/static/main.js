$(document).ready(function(){

    $('.table .eBtn, .table .delBtn').on('click', function(event) {
        event.preventDefault();
        const data = $(this).attr('data');
        const dataTarget = $(this).attr('data-target');
        console.log(data)
        console.log(dataTarget)
        const modal = document.getElementById(dataTarget.substring(1))
        console.log(modal)
        // $("."+dataTarget.substring(1) +" #deleteId").val(data.id);
        // $("."+dataTarget.substring(1) +" #deleteUsername").val(data.firstName);
        // $("."+dataTarget.substring(1) +" #deleteLastname").val(data.lastName);
        // $("."+dataTarget.substring(1) +" #deleteEmail").val(data.email);
        // $("."+dataTarget.substring(1) +" #deleteRoles").val(data.role);
        // $(dataTarget).modal();
    //     var text = $(this).text();
    //     //for update user
    //     if (text == 'Edit') {
    //         $.get(href, function (users, status) {
    //             $('.myFormUpdate #id').val(users.id);
    //             $('.myFormUpdate #username').val(users.username);
    //             $('.myFormUpdate #password').val(users.password);
    //             $('.myFormUpdate #email').val(users.email);
    //         });
    //         $('.myFormUpdate #updateModal').modal();
    //     } else {
    //         //for creating user
    //         $('.myFormCreate #username').val('');
    //         $('.myFormCreate #password').val('');
    //         $('.myFormCreate #email').val('');
    //         $('.myFormCreate #myModalCreate').modal();
    //     }
    // });
    // //for delete user
    // $('.table .delBtn').on('click', function(event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     $('#removeModalCenter #delRef').attr('href', href);
    //     $('#removeModalCenter').modal();
    });
});