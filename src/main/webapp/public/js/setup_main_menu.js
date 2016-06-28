define('setup_main_menu',['jquery', 'underscore', 'backbone', 'primary_dispatcher'],
       function($, _, Backbone, PrimaryDispatcher) {

          PrimaryDispatcher.on("main_menu_setup", function(context, msg) {
            alert("Triggered " + msg);


             $("#listProjs").click(function(){
                    alert("you clicked Project");
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