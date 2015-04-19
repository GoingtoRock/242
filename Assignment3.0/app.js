var fs = require('fs');
var parseString = require('xml2js').parseString;
var xml = fs.readFileSync(__dirname + '/svn_log.xml', 'UTF-8');
var xml2 = fs.readFileSync(__dirname + '/svn_list.xml', 'UTF-8');
var http = require('http');
var index = fs.readFileSync('./index.html');
var swig = require('swig');

var getDateStr = function(dateStr) {
	var tempDate = new Date(dateStr);
	var tempMonth = (tempDate.getMonth() + 1);
	var tempDay = tempDate.getDate();
	if (tempMonth < 10)
		tempMonth = '0' + tempMonth;

	if (tempDay < 10)
		tempDay = '0' + tempDay;

	return tempDate.getFullYear() + '-' + tempMonth + '-' + tempDay;
}


// console.log(xml);
parseString(xml, function (err, logResult) {
	parseString(xml2, function (err, listResult) {

		// fs.writeFileSync("./log.json", JSON.stringify(logResult));
		// fs.writeFileSync("./list.json", JSON.stringify(listResult));

		var newList = [];

		for (var i = 0; i < logResult.log.logentry.length; i++) {
			var entry = logResult.log.logentry[i];

			var entry_temp = {};
			
			entry_temp.version_project = entry.$.revision;
			entry_temp.date_project = getDateStr(entry.date[0]);
			entry_temp.summary_project = entry.msg[0];

			// title of project
			var title = entry.paths[0].path[0]._;
			var newTitleStart = title.indexOf("/", 1);

			newTitle = title.substring(newTitleStart+1, newTitleStart+14);

			if(newTitle.match(/Assignment/g)){
				entry_temp.title_project = newTitle;
			}
			else break;

			// entry_temp.title_project = newTitle;

			// path of files
			// and see if they are created or modified, for on-demand check
			pathList = [];
			actionList = [];
			for (var j = 0; j < entry.paths[0].path.length; j++) {
				var path_entry = entry.paths[0].path[j];

				var newPath = path_entry._;
				newPathStart = newPath.indexOf("/", 1);
				newPath = newPath.substring(newPathStart+1);
				pathList.push(newPath);
				var newAction = path_entry.$.action;
				actionList.push(newAction);
			}

			entry_temp.file = [];

			for (var k = 0; k < listResult.lists.list[0].entry.length; k++) {
				var entry2 = listResult.lists.list[0].entry[k];

				for (var x = 0; x < pathList.length; x++){
					if(entry_temp.version_project == entry2.commit[0].$.revision){

						// create temporary dictionary to store file info
						var tempfile = {};
						
						var status;
						actionList[x] = actionList[x].trim().toUpperCase();
						if(actionList[x] == 'M'){
							status = 'Modified';
						}
						else if(actionList[x] == 'D'){
							status = 'Deleted';
						}
						else if(actionList[x] == 'C'){
							status = 'Conflicted';
						}
						else {
							status = 'Added';
							
						}

						// declare name
						var nameIndex = pathList[x].lastIndexOf('/');
						var fileName = pathList[x].substring(nameIndex+1);

						// declare file size
						var fileType = entry2.$.kind;
						if(fileType == 'file')
							var newSize = entry2.size[0];
						else
							var newSize = 1;

						// declare file type
						var newKind;
						if(fileType == 'Dir'){
							newKind = fileType;
						}
						else if(pathList[x].match(/.idea/g)){
							newKind = 'Configs';
						}
						else if(pathList[x].match(/.gif/g) ||
							pathList[x].match(/.png/g) ||
							pathList[x].match(/.jpg/g)){
							newKind = 'Image';
						}
						else if(pathList[x].match(/.Test/g)){
							newKind = 'Test';
						}

						else if(pathList[x].match(/.Doxy/g)){
							newKind = 'Documentation';
						}
						else if(pathList[x].match(/.txt/g)){
							newKind = 'Text file';
						}
						else 
							newKind = 'Code';
						
						entry_temp.file.push({
							'FileName': fileName,
							'FilePath': pathList[x],
							'Version':entry2.commit[0].$.revision,
							'Author':entry2.commit[0].author[0],
							'Date': getDateStr(entry2.commit[0].date[0]),
							'Size':newSize,
							'Type':newKind,
							'status':status

						});
					}
				}
			}
			newList.push(entry_temp);
			
		}

		var tpl = swig.compileFile('./index.html');
		tpl = tpl({ lists: newList });
		http.createServer(function(req, res) {
			res.writeHead(200, {'Content-Type': 'text/html'});
			res.end(tpl);
		}).listen(3000);
	});
});