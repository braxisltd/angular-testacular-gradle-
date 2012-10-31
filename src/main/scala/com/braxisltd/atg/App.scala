package com.braxisltd.atg

import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response.{NotFound, Redirect}
import javax.servlet.{FilterChain, ServletResponse, ServletRequest}
import unfiltered.jetty.Http
import java.net.URL

class App extends Plan {
    def intent = {
        case GET(Path(path)) => NotFound
    }

    override def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        try {
            super.doFilter(request, response, chain)
        } catch {
            case e => e.printStackTrace()
        }
    }
}

object App {
    def main(args: Array[String]) {
        Http.local(8000)
            .context("/app")(contextBuilder => contextBuilder.resources(new URL("file:///C:/Users/Darren/IdeaProjects/angular-testacular-gradle/app")))
            .context("/test")(contextBuilder => contextBuilder.resources(new URL("file:///C:/Users/Darren/IdeaProjects/angular-testacular-gradle/test")))
            .start()
    }
}