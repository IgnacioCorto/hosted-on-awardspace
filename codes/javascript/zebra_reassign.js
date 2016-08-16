
/*
 *   AN USEFUL SCRIPT FOR SORTING TABLES IS AT:
 *   http://www.kryogenix.org/code/browser/sorttable/
 */

$(function(){
    $('.gvfooterstyle th').click(function(e){
        var table = $(this).parents('table.tableReport.sortable') ;
        var allRows = table.find('tr') ;
        var evenRows = table.find('tr:even') ;
        allRows.removeClass('gvalternatingrowstyle');
        evenRows.addClass('gvalternatingrowstyle');
    });
});
