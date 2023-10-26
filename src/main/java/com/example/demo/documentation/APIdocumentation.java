package com.example.demo.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(

		info = @Info(
				// customize the fields using info
				title = "Data Object API",

				description = "Conversion of entity to data object and vice-versa",

				summary = "This API will save the user data , find by ID and find all users API's",

				termsOfService = "Terms & Conditions",

				contact = @Contact(name = "Tejas Chodhari ", email = "tejaschodhari3419@gmail.com"),

				license = @License(name = "license number - S87DF6WD6SW9F"),

				version = "v1.0.3"),

		// server customization

		servers = { @Server(description = "Dev", url = "http://localhost:8686"),

				@Server(description = "Test", url = "http://localhost:8686") }

// security for all the controllers in the appllication
//		security = @SecurityRequirement(
//				name = "Star Health Authentication"
//				)

)

//@SecurityScheme(
//		name = "Star Health Authentication",
//		in = SecuritySchemeIn.HEADER,
//		type = SecuritySchemeType.HTTP, // type																											// authentication
//		bearerFormat = "JWT", // format of bearer (acess tokens, JWT , ID Tokens )
//		description = "Authentication Process",
//		scheme = "bearer" // bearer = giving acess using token
//)

@SecuritySchemes({
    @SecurityScheme(
        name = "APIKeyAuth",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        paramName = "API"
    )
})

public class APIdocumentation {

}
