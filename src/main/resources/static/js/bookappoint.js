  $(document).ready(function(){
		
		var date = new Date();
		
		var mnth = (date.getMonth()+1);
		
		var dt	 =	date.getDate();
		if(dt<10)
		{
			dt= "0"+dt;	
		}
		
		if(mnth <10 ){
				mnth = "0"+mnth;
		}
		
		today = date.getFullYear()+"-"+ mnth+"-"+ dt; 
		
	  	$('#sbapt').click(function(e){
			
			if($('#company').val()==null)
			{
				e.preventDefault();
				alert("Please Select Company Name");
				$('#company').focus();
			}
			if($('#employee').val()==null)
			{
				e.preventDefault();
				
				alert("Please Select Employee Name");
				$('#vis_person').focus();
				
			}
			if($('#status').val()==null)
			{
				e.preventDefault();
				
				alert("Please Select Appointment Status");
				$('#status').focus();
			}
			
		}); 
	  
	  
  	$('#apdate').datetimepicker({ 

		minDate	: 	today,
		
		format	:	'YYYY-MM-DD'
	});

	
  	$('#company').select2({
			theme	:	'classic',
			width	:	'resolve'
	});
	
	
	$('#employee').select2({
		theme	:	'classic',
		width	:	'resolve'
	});
	
	
	$('#department').select2({
		theme	:	'classic',
		width	:	'resolve'
	});
	
	$('#apdate').focusout( function(){ 
		
		if($('#apdate').val()==today)
		{
		   $('#datetime').datetimepicker({ 
	          	
	    		format: 'hh:mm:ss A',
	    		
	    		minDate: moment(),
	    		 
	    		icons: {
	    				time	: 'fa fa-clock-o',
	    				date	: 'fa fa-calendar',
	    				up		: 'fa fa-chevron-up',
	    				down	: 'fa fa-chevron-down',
	    				previous: 'fa fa-chevron-left',
	    				next	: 'fa fa-chevron-right',
	    				today	: 'fa fa-check',
	    				clear	: 'fa fa-trash',
	    				close	: 'fa fa-times'
	    			},
	    	});
		}
		else
		{
		     $('#datetime').datetimepicker({ 
	          	
	    		format: 'hh:mm:ss A',
	    
	    		icons: {
	    				time	: 'fa fa-clock-o',
	    				date	: 'fa fa-calendar',
	    				up		: 'fa fa-chevron-up',
	    				down	: 'fa fa-chevron-down',
	    				previous: 'fa fa-chevron-left',
	    				next	: 'fa fa-chevron-right',
	    				today	: 'fa fa-check',
	    				clear	: 'fa fa-trash',
	    				close	: 'fa fa-times'
	    			},	
	    	});
		}
	 });
  });
 
  function getDeptByCompId(compid)
 {
	 var tapp="";
		
		$.ajax({
				async    : true,
				type     : "GET",
			    url      : "/getdeptbycompid/"+compid,
				dataType : "json",
				success  : function(result) {
					
					$('select[name="department"]').empty();
					$('select[name="department"]').append('<option selected disabled>Please Select Department</option');
					
					$('select[name="company"]').empty();
					$('select[name="company"]').append('<option selected disabled>Please Select Company</option');
					
					$.each(result,function(i){
						$('select[name="department"]').append('<option selected value="'+result[i].dept_id+'">'+result[i].dept_name+'</option>');
						$('select[name="company"]').append('<option selected value="'+result[i].company.comp_id+'">'+result[i].company.comp_name+'</option>');
					});
				}
	 });
 }
  
//function getDeptByEmpId(empid)
//{	
//	 	$('#department').empty();
// 		$('#company').empty();
//	 	
//		$.ajax({
//				async    : true,
//				type     : "GET",
//			    url      : "getdeptbyempid/"+empid,
//				
//				success  : function(result) {
//					
//					var size = Object.keys(result).length;
//					
//					$('select[name="department"]').append('<option selected value="'+result.department.dept_id+'">'+result.department.dept_name+'</option>');
//					$('select[name="company"]').append('<option selected value="'+result.company.company_id+'">'+result.company.comp_name+'</option>');
//
//				}
//	 });
//}