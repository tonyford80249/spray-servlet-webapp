define('primary_view', ['jquery', 'underscore', 'backbone', 'base_view', 'content_view', 'top_menu_view', 'modal_view', 'primary_dispatcher','setup_main_menu'],
       function($, _, Backbone, BaseView, ContentPane, TopMenuView, ModalView, PrimaryDispatcher) {
           var content  = new ContentPane();


            //var content  = new GenerateBaselinePane();

           //'generate_baseline_view','baseline_compare_view','baseline_search_view','baseline_dir_compare_view','baseline_stats_view','delta_search_view'
           return Backbone.View.extend(_.extend(BaseView, {               
               el: 'body',
               initialize: function() {
                   var self = this;

                    PrimaryDispatcher.on('display_content', function(new_content, msg) {

                       self.unassign(content);
                       self.$("#maintContentSection").html('<div id="contentWrapper"></div>');

                       ///content = new ProjectView();
                       self.assign(new_content, '#contentWrapper');

                       content = new_content;
                    });

                
                   self.render();                                                                                
               },
               renderPage: function(pagename) {
                    var self = this;
                    
                    self.unassign(content);
                    this.$("#maintContentSection").html('<div id="contentWrapper"></div>');

                    require([pagename], function(view) {
                       content = view

                       self.assign(content, '#contentWrapper');
                    });
               },
               rendering: function(){
                   this.$el.append('\
                        <div class="container">\
                           <div id="topMenuBarSection"></div>\
                           <div id="maintContentSection"></div>\
                           <div id="modalSection"></div>\
                           <div id="toolTip"></div>\
                        </div>\
                    ');           
               },
               afterRendering: function() {
                   var self = this;
                    
                   this.$("#maintContentSection").html('<div id="contentWrapper"></div>');

                  self.assign(new TopMenuView(), '#topMenuBarSection');

                   //self.assign(TopMenuView, '#topMenuBarSection');
                   
                   self.assign(content, '#contentWrapper');

                   self.assign(new ModalView(), '#modalSection');

                   PrimaryDispatcher.trigger("main_menu_setup", {self:this, ref: this.$} ,"display menu");

                   //self.assign(ModalView, '#modalSection');

                   //addClick("#genbaselinebtn",'generate_baseline_view',self);

                   //addClick("#baselinecomparebtn",'baseline_compare_view',self);

                   //addClick("#baselinesearchbtn",'baseline_search_view',self);

               }
           }));
});