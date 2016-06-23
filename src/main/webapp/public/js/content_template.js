define('content_template',['handlebars', 'text!html/content.html'],
       function(Handlebars, html){
          return  Handlebars.compile(html);
       });