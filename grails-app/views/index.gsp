<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Grails Chained Select</title>
</head>

<body>

<div id="page-body" role="main">
    <h1>Welcome</h1>

    <p>This is an example of chaining select boxes with grails.</p>


    <div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'continent', 'error')} required">
        <label for="continent">
            Continent
            <span class="required-indicator">*</span>
        </label>
        <g:select id="continent" name="continent.id" from="${chained.selects.Continent.list()}" optionKey="id" required="" value="${countryInstance?.continent?.id}" class="many-to-one"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'continent', 'error')} required">
        <label for="continent">
            Country
            <span class="required-indicator">*</span>
        </label>
        <select id="country"></select>
    </div>

    <div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'continent', 'error')} required">
        <label for="continent">
            City
            <span class="required-indicator">*</span>
        </label>
        <select id="city"></select>
    </div>

</div>

<g:javascript library="jquery" plugin="jquery"/>
<r:script>

    function getCountries() {
             $.ajax({
        url:"${createLink(controller: 'continent', action: 'index')}/"+$('#continent').val() ,
        async: false
    })
    .done(function(data){
        $('#country').empty();
       $(data).each(function(idx,ele){
            var option = $('<option>', { value: ele.id, text : ele.country });
$('#country').append(option);
});
});
}

function getCities() {
$.ajax({
url:"${createLink(controller: 'country', action: 'index')}/"+$('#country').val() ,
async: false
})
.done(function(data){
$('#city').empty();
$(data).each(function(idx,ele){
var option = $('<option>', { value: ele.id, text : ele.city });
                    $('#city').append(option);
                });
            });
    }


    $('#continent').on('change', function () {
        getCountries();
        getCities();
    })


    $('#country').on('change', function () {
        getCities();
    })

    $(document).ready(function () {
        getCountries();
        getCities();
    });

</r:script>
</body>
</html>
