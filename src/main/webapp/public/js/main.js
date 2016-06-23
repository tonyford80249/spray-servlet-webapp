require.config({
    //By default load any module IDs from js/lib
    baseUrl: '/spray/public/js/',
            
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
    paths: {
        'jquery': '//code.jquery.com/jquery-latest.min',
        'jquery.dataTables':'//cdn.datatables.net/1.10.4/js/jquery.dataTables.min',        
        'text': 'text',
        'backbone':'//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min',
        'bootstrap': '//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min',
        'bootstrapselect': '//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap-select.min',
        'handlebars': 'handlebars-v1.3.0',
        'underscore': 'underscore-min',
        'datepicker': 'datetimepicker',
        'locale':'grid.locale-en'
            
    },
    underscore: {
                exports: '_'
    },
     shim: {
         'jquery': {
            exports: '$ '
        },'jquery.dataTables': {
            deps: ['jquery'],
            exports: 'DataTable'
         },   
         'backbone': {
                deps: [ 'underscore', 'jquery' ],
                exports: 'Backbone'
            },
         'bootstrap': {
                deps: [ 'jquery' ],
                exports: 'Bootstrap'
            },
        'handlebars': {
            deps: ['jquery', 'underscore'],
            exports: 'Handlebars'
        },
        'datepicker': {
            deps: ['jquery'],
            exports: 'DateTimePicker'
        }
    }
});

// Start the main app logic.
require(['jquery', 'primary_view'],
function($, PrimaryView) {
    new PrimaryView();    
});