$(document).ready(function () {
    let productsInCart = [];
    let buttonLabel = "";

    //add product to cart button clicked
    $(document).on("click","#product input",function(){
         const newProduct = productsInCart.lastIndexOf(this.id) < 0;
            if (newProduct) {
                productsInCart.push(this.id);
                buttonLabel = 'Remove from cart';
                $(this).css('background', "black");
            } else {
                productsInCart.pop();
                buttonLabel = "Add to cart"
                $(this).css('background', "#b00020");
            }

            this.value = buttonLabel;
            $("#total-cart").text(productsInCart.length);

            //enable/disable the checkout [submit] button.
            $("#checkout").attr("disabled", productsInCart.length <= 0);
    });
    // $("#product input").click(function () {
    //     const newProduct = productsInCart.lastIndexOf(this.id) < 0;
    //     if (newProduct) {
    //         productsInCart.push(this.id);
    //         buttonLabel = 'Remove from cart';
    //         $(this).css('background', "black");
    //     } else {
    //         productsInCart.pop();
    //         buttonLabel = "Add to cart"
    //         $(this).css('background', "#b00020");
    //     }
    //
    //     this.value = buttonLabel;
    //     $("#total-cart").text(productsInCart.length);
    //
    //     //enable/disable the checkout [submit] button.
    //     $("#checkout").attr("disabled", productsInCart.length <= 0);
    // });

    //add products to hidden input field
    $("#checkout").click(function () {
        $("#productsOnCart").val(productsInCart);

    });


    //load all data
    const search = $("#search").val();

    if(search==null || search==""){
        $.ajax({
            type: "post",
            url: "search",
            data: {searchTerm: ""},
            success: function (response) {

                let html = response.map(function (obj) {
                    let line1 = "<div class='product' id='product'><h1>" + obj.name + "</h1>";
                    let line2 = "<img alt=img src=images/" + obj.id + " />";
                    let line3 = "<p>$" + obj.price +"</p>";
                    let line4 = "<input type='button' value='Add to cart' id='" + obj.id + "'/></div>";

                    return line1.concat(line2, line3, line4);
                });

                //alert(data);

                $("#product_list").html(html);
            }
        });
    }


    $("#search").keyup(function () {
        let productName = $("#search").val();

        $.ajax({
            type: "post",
            url: "search",
            data: {searchTerm: productName},
            success: function (response) {

                let html = response.map(function (obj) {
                    let line1 = "<div class='product' id='product'><h1>" + obj.name + "</h1>";
                    let line2 = "<img alt=img src=images/" + obj.id + " />";
                    let line3 = "<p>$" + obj.price +"</p>";
                    let line4 = "<input type='button' value='Add to cart' id='" + obj.id + "'/></div>";

                    return line1.concat(line2, line3, line4);
                });

                //alert(data);

                $("#product_list").html(html);
            }
        });
    });
});