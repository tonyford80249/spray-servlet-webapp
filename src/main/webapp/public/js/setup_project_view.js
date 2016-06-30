define('setup_project_view',['jquery', 'underscore', 'backbone', 'project_view', 'primary_dispatcher'],
       function($, _, Backbone, ProjectView, PrimaryDispatcher) {

          PrimaryDispatcher.on("setup_project_view", function(context, msg) {
             var content = new ProjectView();

             PrimaryDispatcher.trigger('display_content',content,"display");
          });

          return PrimaryDispatcher;
       });