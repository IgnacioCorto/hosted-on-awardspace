/*****
Dynamic Javascript Breadcrumb Navigation by Adam DuVander
http://duvinci.com/projects/javascript/crumbs/

Released under Creative Commons License:
http://creativecommons.org/licenses/by/2.5/
*****/
var crumbsep = " > ";
var precrumb = "<span id=\"breadcrumb_txt\">";
var postcrumb = "</span>";
var sectionsep = "/";
var rootpath = "/"; // Use "/" for root of domain.
var rootname = "Home";

var ucfirst = 1; // if set to 1, makes "directory" default to "Directory"

var objurl = new Object;
objurl['our_products'] = 'Our Products';
objurl['about_us'] = 'About us';
objurl['where_to_buy'] = 'Where to buy';
objurl['hand_made'] = 'Hand made cigars';
objurl['machine_made'] = 'Machine made cigars';
objurl['super_premium'] = 'Super Premium';

// Grab the page's url and break it up into directory pieces
var pageurl = (new String(document.location));
var protocol = pageurl.substring(0, pageurl.indexOf("//") + 2);
pageurl = pageurl.replace(protocol, ""); // remove protocol from pageurl
var rooturl = pageurl.substring(0, pageurl.indexOf(rootpath) + rootpath.length); // find rooturl
if (rooturl.charAt(rooturl.length - 1) == "/") //remove trailing slash
{
  rooturl = rooturl.substring(0, rooturl.length - 1);
}
pageurl = pageurl.replace(rooturl, ""); // remove rooturl fro pageurl
if (pageurl.charAt(0) == '/') // remove beginning slash
{
  pageurl = pageurl.substring(1, pageurl.length);
}

var page_ar = pageurl.split(sectionsep);
var currenturl = protocol + rooturl;
var allbread = precrumb + "<a href=\"" + currenturl + "\">" + rootname + "</a>" + postcrumb; // start with root

for (i=0; i < page_ar.length-1; i++)
{
  var displayname = "";
  currenturl += "/" + page_ar[i];
  if (objurl[page_ar[i]])
  {
    displayname = objurl[page_ar[i]];
  }
  else
  {
    if (ucfirst == 1)
    {
      displayname = page_ar[i].charAt(0).toUpperCase() + page_ar[i].substring(1);
    }
    else
    {
      displayname = page_ar[i];
    }
  }
  allbread += crumbsep + precrumb + "<a href=\"" + currenturl + "\">" + displayname + "</a>" + postcrumb;
}
document.write(allbread + crumbsep + document.title);
