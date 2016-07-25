/**
 * Created by mnzero on 16-7-22.
 */
function selectChanage() {
    var selObj = document.getElementById("schoolYear");
    var i = selObj.selectedIndex;
    $.get("qPAction_list.action", {schoolYear: selObj.options[i].value});
}
