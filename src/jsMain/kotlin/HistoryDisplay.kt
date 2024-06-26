import csstype.ClassName
import react.*
import kotlinx.browser.window
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.tbody
import react.dom.html.ReactHTML.td
import react.dom.html.ReactHTML.th
import react.dom.html.ReactHTML.thead
import react.dom.html.ReactHTML.tr

external interface HistoryDisplayProps : Props {
    var clickFun: (Int) -> Unit

    var history: List<Pair<BoardState,String>>
}

val HistoryDisplay = FC<HistoryDisplayProps> { props ->
    div {
        id = "history"


        table {
            var count = 0
            tr {
                th {
                    div {
                        className = ClassName("content")
                        +"White"
                    }
                }
                th {
                    div {
                        className = ClassName("content")
                        +"Black"
                    }
                }
            }
            while (count < props.history.size) {
                tr {
                    td {
                        div {
                            className = ClassName("content")
                            +"${props.history[count].first.fullMoveNumber}. ${props.history[count].second}"
                            onClick = {
                                props.clickFun(count)
                            }
                        }
                    }
                    count++
                    td {
                        div {
                            className = ClassName("content")
                            if (count < props.history.size) {
                                +"${props.history[count].first.fullMoveNumber}. ${props.history[count].second}"
                                onClick = {
                                    props.clickFun(count)
                                }
                            }
                            else {
                                +" "
                            }
                        }
                    }
                }
                count++
            }
        }


    }
}
