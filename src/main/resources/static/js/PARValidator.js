var PARValidationUtil = PARValidationUtil || {};
PARValidationUtil.utils = {};
(function(module,$, undefined){
	//required
	//minlength
	//maxlength
	//isdate
	//email
	//phonenumber
	
	module().init = function(){
		PARValidationUtil.utils.notEmpty();
	};
	
	module().validationProperties={
		errorElement: "em",
		errorPlacement: function ( error, element ) {
			// Add the `help-block` class to the error element
			error.addClass( "help-block" );

			// Add `has-feedback` class to the parent div.form-group
			// in order to add icons to inputs
			element.parents( ".col-sm-5" ).addClass( "has-feedback" );

			if ( element.prop( "type" ) === "checkbox" ) {
				error.insertAfter( element.parent( "label" ).parent( ".input-group" ) );
			} else {
				error.insertAfter( element.parent( ".input-group" ) );
			}

			// Add the span element, if doesn't exists, and apply the icon classes to it.
			if ( !element.next( "span" )[ 0 ] ) {
				$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
			}
		},
		success: function ( label, element ) {
			// Add the span element, if doesn't exists, and apply the icon classes to it.
			if ( !$( element ).next( "span" )[ 0 ] ) {
				$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
			$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
		},
		unhighlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
			$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
		}
	};
	
	module().notEmpty = function(){
		jQuery.validator.addMethod("notEmpty", function(value, element, params) {
		    return this.optional(element);
		}, jQuery.validator.format("{0} can not be empty"));
	}
})(function() {return PARValidationUtil.utils;}, jQuery);


$( document ).ready(function() {
	PARValidationUtil.utils.init();
});