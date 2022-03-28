var vueObj;

$(() => {
    $('button[mode]').on('click', (event) => {
        let mode = $(event.currentTarget).attr('mode');
        let column = $('#columns-combobox').find(":selected").text();

        getData(mode, column);
    });

    vueObj = new Vue({
        el: '#result-container',
        template: '#datatable',
        data: {
            entities: []
        }
    });
});

function getData(mode, column) {
    $('#result-container').empty();

    axios.get('/examentities/' + mode + '/' + column)
            .then((response) => {
                console.log(response.data);
                showData(response.data);
            })
            .catch((error) => {
                console.log(error);
                alert(error);
            });
}

function showData(data) {
    if(data.length === 0){
        data = [{id: 'NOTHING FOUND', col1: '', col2: '', col3: '', col4: ''}];
    }
        
    vueObj.entities = data;
}