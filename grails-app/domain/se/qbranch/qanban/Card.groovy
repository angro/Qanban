package se.qbranch.qanban

class Card {

    static constraints = {
        title(blank:false, length:1..50)
        description(length:1..300)
        assignee(blank: true, nullable: true)
        phase(nullable: true)
    }

    String title
    String description
    Integer caseNumber

    // Auto timestamps (changed when db is updated)
    Date dateCreated
    Date lastUpdated

    //TODO: Ska vara AD-User sen
    User assignee
    Phase phase
}
