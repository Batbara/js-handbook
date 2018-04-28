$(document).ready(function () {
    $('.site-info').html($('.site-info').html().replace(/\\n/g, "<br/>"));
    $('#addJsObject').hide();
    $('#addMethod').hide();
    $('#addOperator').hide();
    $('#edit-article').hide();

    var operatorListPos = window.sessionStorage["operatorListPos"];
    if (operatorListPos) {
        $('#operatorList').scrollTop(operatorListPos)
    }

    var objectListPos = window.sessionStorage["objectListPos"];
    if (objectListPos) {
        $('#objectList').scrollTop(objectListPos)
    }
    makeActiveLink();
});

function makeActiveLink() {
    var loc = location.pathname + location.search;

    $('.nav-tree').find('a').each(function () {
        $(this).toggleClass('active', $(this).attr('href') == loc);
    });
}

$('#editArticleBtn').click(function () {
    $('#edit-article').show();
    $('#addJsObject').hide();
    $('#addMethod').hide();
    $('#addOperator').hide();
});
$('#addMethodBtn').click(function () {
    $('#addMethod').show();
    $('#addJsObject').hide();
    $('#addOperator').hide();
    $('#edit-article').hide();
});
$('#addJsObjectBtn').click(function () {
    $('#addJsObject').show();
    $('#edit-article').hide();
    $('#addOperator').hide();
    $('#addMethod').hide();
});
$('#addOperatorBtn').click(function () {
    $('#addJsObject').hide();
    $('#edit-article').hide();
    $('#addOperator').show();
    $('#addMethod').hide();
});
$('#objectList').scroll(function () {
    if ($('#objectList').html().length) {
        window.sessionStorage.setItem("objectListPos", $('#objectList').scrollTop());
    }
});
$('#operatorList').scroll(function () {
    if ($('#operatorList').html().length) {
        window.sessionStorage.setItem("operatorListPos", $('#operatorList').scrollTop());
    }
});


