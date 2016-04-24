<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>

</head>
<body>
 
 <form action="fill.html" method="post">
 <p>event name: <input type="text" id="test" name="event_name"></p>
<p>event type: 
 <select id="category" name="event_type">
   <option value="none">------</option>
  <option value="pre_placement">pre_placement</option>
  <option value="aptitude">aptitude</option>
  <option value="interview">interview</option>
</select> 
</p>

<p>company name: <input type="text" id="test" name="company_name"></p>

<p>approved: <input type="text" id="test" name="approved"></p>

<p>date: <input type="text" id="test" name="date"></p>

<p>time: <input type="text" id="test" name="time"></p>

<p>venue: <input type="text" id="test" name="venue"></p>

<!-- pre_placement -->

<div class="pre_placement" hidden>
<p>conducted_by: <input type="text" id="test" name="conducted_by"></p>

<p>agenda: <input type="text" id="test" name="agenda"></p>
</div>

<!-- aptitude -->
<div class="aptitude" hidden>
<p>test_duration: <input type="text" id="test" name="test_duration"></p>

<p>subjects_to_be_prepared: <input type="text" id="test" name="subjects_to_be_prepared"></p>

<p>test_section: <input type="text" id="test" name="test_section"></p>
</div>

<!-- interview -->
<div class="interview" hidden>
<p>interview_type: <input type="text" id="test" name="interview_type"></p>
</div>




<button>Show Value</button>
</form>

<script>
$(document).ready(function(){
	$( "#category" ).change(function() {
				
				var typ=$( "#category").val();
				
				
				switch(typ){
					case "training":
						
						$(".pre_placement").hide();
						$(".interview").hide();
						$(".aptitude").hide();
						$(".training").show();
						
						break;
					case "aptitude":
						
						$(".pre_placement").hide();
						$(".interview").hide();
						$(".aptitude").show();
						$(".training").hide();
						break;
					
					case "interview":
						
						
						$(".pre_placement").hide();
						$(".interview").show();
						$(".aptitude").hide();
						$(".training").hide();
						break;
						
					case "pre_placement":
						
						$(".pre_placement").show();
						$(".interview").hide();
						$(".aptitude").hide();
						$(".training").hide();
							
						break;
				}
				
				
	});
	
	
});
</script>
</body>
</html>
