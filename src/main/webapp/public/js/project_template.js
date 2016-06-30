define('project_template',['handlebars', 'text!html/project.html'],
       function(Handlebars, html){
          return  Handlebars.compile(html);
       });