package rewards

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "client", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
