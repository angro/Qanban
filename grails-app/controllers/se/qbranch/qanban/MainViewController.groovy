package se.qbranch.qanban

import org.codehaus.groovy.grails.plugins.springsecurity.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class MainViewController {

    def securityService
    def index = { redirect(action:view,params:params)  }

    def view = {
        [ board : Board.get(1), loggedInUser: securityService.getLoggedInUser() ]
    }

    def showBoard = {
        render(template: "/board/board", bean: Board.get(1))
    }

    def showLog = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        render(template: "/event/log", model: [ eventInstanceList: Event.list( params ), eventInstanceTotal: Event.count() ])
    }

    def showLogBody = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        render(template: "/event/logBody", model: [ eventInstanceList: Event.list( params ), eventInstanceTotal: Event.count() ])
    }

}


