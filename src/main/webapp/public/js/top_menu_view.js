define('top_menu_view',['jquery', 'underscore', 'backbone', 'base_view'], 
       function($, _, Backbone, BaseView) {
  
           return Backbone.View.extend(_.extend(BaseView, {
               
               rendering: function() {
                   $(this.el).append('<div class="navbar navbar-inverse navbar-static-top" role="navigation"><div class="container-fluid"><div class="navbar-header"><button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a class="navbar-brand" href="#">GHOST SERVER</a></div><div class="navbar-collapse collapse"><ul class="nav navbar-nav navbar-right"><li class="active"><ul class="nav navbar-nav navbar-right"><li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Commands <span class="caret"></span></a><ul class="dropdown-menu" role="menu"><li><a id="genbaselinebtn" href="#">Generate Baseline</a></li><li><a id="baselinecomparebtn" href="#">Compare Baseline</a></li><li><a id="baselinesearchbtn" href="#">Search Baseline</a></li><li><a id="baselinedircomparebtn" href="#">Baseline Directory Compare</a></li><li><a id="baselinestatsbtn" href="#">Baseline Stats</a></li><li class="divider"></li><li><a id="deltasearchbtn" href="#">Delta Search</a></li><li><a id="baselinecalcbtn" href="#">Baseline Calculation</a></li></ul></li></li><li><a id="realtimebtn"href="#">Real Time Tracking</a></li><li><a id="backupbtn" href="#">Backup</a></li><li><a id="schedbtn" href="#">View Schedule</a></li><li><a id="restorebtn" href="#">Restore</a></li><li><a id="autopurgebtn" href="#">Auto Purge</a></li><li><a href="#">Contact Us</a></li><li><a href="#help" data-toggle="modal">Help</a></li></ul></div></div></div>');
               }
           }));
  
});

