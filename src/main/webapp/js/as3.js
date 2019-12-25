$('document').ready(function () {

    $('#add').on('click', function () {
        var result;
        var entry = $('#addEntryToCSV').val();
        $.ajax({
            url: 'http://localhost:8080/addEntryToCSV',
            datatype: 'json',
            contentType: "application/json",
            data: {
                entry: entry
            },
            success: function (data) {
                result = data;
                alert(data);
            }
        });
    });

    $('#save').on('click', function () {
        var result;
        $.ajax({
            url: 'http://localhost:8080/saveEntry',
            // datatype: 'json',
            // contentType: "application/json",
            success: function (data) {
                result = data;
                alert(data);
            }
        });
    });
});