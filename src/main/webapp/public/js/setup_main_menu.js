define('setup_main_menu',['jquery', 'underscore', 'backbone', 'primary_dispatcher', 'setup_project_view'],
       function($, _, Backbone, PrimaryDispatcher) {

          PrimaryDispatcher.on("main_menu_setup", function(context, msg) {
            alert("Triggered " + msg);


             $("#listProjs").click(function(){
                 PrimaryDispatcher.trigger('setup_project_view', context, "show project view");
             });

             $("#listEpics").click(function(){
                    alert("you clicked epic");
             });

             $("#listStorys").click(function(){
                    alert("you clicked story");
             });

             $("#listShortStories").click(function(){
                    alert("you clicked short story");
              });

             $("#listCoverStories").click(function(){
                     alert("you clicked cover story");
              })

             $("#listThemes").click(function(){
                    alert("you clicked themes");
              });


          });

          return PrimaryDispatcher;
       });