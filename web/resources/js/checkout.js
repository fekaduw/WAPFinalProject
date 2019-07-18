$(document).ready(function () {
    calculateTotal();


    $("select.quantity").change(function () {
        const selected = $(this).children('option:selected').val();

        const selectedId = $(this).children('option:selected').attr('id');

        const unitPrice = $("span#p"+selectedId).html();

        let newItemTotal = parseFloat(selected) * unitPrice;

        let totalString = $("#total").text();
        let currentTotal = totalString.substring(1, totalString.length) - unitPrice;

        let newTotal = currentTotal + newItemTotal;

        $("#total").text("$" + newTotal);

        calculateTotal();
    });

});

function calculateTotal() {
    let totalString = $("#total").text();
    let total = totalString.substring(1, totalString.length);

    let shippingString = $("#shipping").text();
    let shipping = shippingString.substring(1, shippingString.length);

    const taxRate = 0.10;
    let totalBeforeTax = parseFloat(total) + parseFloat(shipping);

    let tax = totalBeforeTax * taxRate;

    let orderTotal = totalBeforeTax + tax;
    $("#totalBeforeTax").text("$" + totalBeforeTax);
    $("#tax").text("$" + tax);
    $("#orderTotal").text("$" + orderTotal);
}