/**
 * Global Parameters
 */

// selected tvId
selectedTvId = undefined;

/**
 * Download File
 */
function downloadURL(url) {
    var hiddenIFrameID = 'hiddenDownloader',
        iframe = document.getElementById(hiddenIFrameID);
    if (iframe === null) {
        iframe = document.createElement('iframe');
        iframe.id = hiddenIFrameID;
        iframe.style.display = 'none';
        document.body.appendChild(iframe);
    }
    iframe.src = url;
};

function addPanel(){
    index++;
    $('#tt').tabs('add',{
        title: 'Tab'+index,
        content: '<div style="padding:10px">Content'+index+'</div>',
        closable: true
    });
}

/**
 * welcome dialog
 */
function closeWelcomeDialog() {
	$('#welcome_dialog').dialog('close');
}

/**
 * JOB list
 */
function loadJobList() {
	$('#tb_job_list').datagrid('load',{
		// owner: 'CHLEEZO'
	});
}


/**
 * Submit JOB 
 */
function onSelectJobTv(rec) {
	$('#cb_new_job_control_circuit_list').combobox('reload', './ws/rs/project/control_circuit/list?tvId='+rec.tvId);
	$('#cb_new_job_drc_deck_list').combobox('reload', './ws/rs/project/drc_deck/list?tvId='+rec.tvId);
	$('#cb_new_job_lvs_deck_list').combobox('reload', './ws/rs/project/lvs_deck/list?tvId='+rec.tvId);
	$('#cb_new_job_rc_deck_list').combobox('reload', './ws/rs/project/rc_deck/list?tvId='+rec.tvId);
	$('#cb_new_job_spice_model_list').combobox('reload', './ws/rs/project/spice_model/list?tvId='+rec.tvId);
}

function submitNewJob() {
	$('#form_add_job').form('submit');
}

function startAcmeJobTab() {
	$('#acme_tab').tabs('select', 'Job Application');
}

function chooseVehicle() {
	$(jobStageTabName).tabs('select', 'Choose Vehicle');
	var activeStageId = getActiveStageId();
	highlightJobStage(activeStageId);
}

function setupGds() {
	$('#dd_job_stage_tv_submit').dialog('open');
	$('#ff_job_stage_tv').submit();
}

function chooseDrcDeck() {
	$(jobStageTabName).tabs('select', 'Choose DRC Deck');
	var activeStageId = getActiveStageId();
	highlightJobStage(activeStageId);
}
function chooseLvsDeck() {
	$(jobStageTabName).tabs('select', 'Choose LVS Deck');
	var activeStageId = getActiveStageId();
	highlightJobStage(activeStageId);
}
function chooseRcDeck() {
	$(jobStageTabName).tabs('select', 'Choose RC Deck');
	var activeStageId = getActiveStageId();
	highlightJobStage(activeStageId);
}
function chooseSpiceModel() {
	$(jobStageTabName).tabs('select', 'Choose SPICE Model');
	var activeStageId = getActiveStageId();
	highlightJobStage(activeStageId);
}

function seleteComposedGds() {
	$("#seleteComposedGds").css("visibility", "visible");
	$("#seleteComposeNewGds").css("visibility", "hidden");
}

function seleteComposeNewGds() {
	$("#seleteComposedGds").css("visibility", "hidden");
	$("#seleteComposeNewGds").css("visibility", "visible");
}

/*
 * Job Summary
 */
function openJobSummary() {
    var row = $('#tb_job_list').datagrid('getSelected');
    if (row){
        // $.messager.alert('Info', row.jobId + ":" + row.jobName + ":" + row.createTime);
    	
    	$('#grid_job_cell_info').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_placement').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_src_gds').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_netlist').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_testbench').datagrid('load', {
    	    jobId: row.jobId
    	});
    	/*
    	*/
    	
    	// load results
    	$('#grid_job_drc_result').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_lvs_result').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_rc_result').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	$('#grid_job_spice_result').datagrid('load', {
    	    jobId: row.jobId
    	});
    	
    	// open window
    	$('#win_job_detail').window('open');
    }
}

function closeJobSummary() {
	$('#win_job_detail').window('close');
}

function getActiveJobSummaryTabId() {
	var tab = $(jobStageTabName).tabs('getSelected');
	var activeJobSummaryTabId = $(jobStageTabName).tabs('getTabIndex',tab);
	
	return activeJobSummaryTabId;
};

function formatDrcResultFile(val,row){
	//return '<span style="color:red;">('+val+')</span>';

	//var downloadFileUrl = './ws/rs/job/txt';
	var downloadFileUrl = './ws/rs/job/zip';
	return '<a href="' + downloadFileUrl  + '">Download</a>';
}

/*
 * maintain project
 */
function reloadTvTree() {
	//var node = $('#tree_tv_list').tree('find',113);
    //$('#tt').tree('expandTo', node.target).tree('select', node.target);
}

function openWinAddVehicle() {
	$('#win_add_vehicle').window('open');
}

function submitWinAddVehicle() {
	$('#win_add_vehicle').window('close');
	$('#form_add_vehicle').form('submit');
}

function clearWinAddVehicle() {
	$('#form_add_vehicle').form('clear');
}

function cancelWinAddVehicle() {
	$('#form_add_vehicle').form('clear');
	$('#win_add_vehicle').window('close');
}

/**
 * load control circuit by tvId
 * @param selectedTvId
 */
function loadControlCircuitListByTv(selectedTvId) {
	$('#grid_tv_control_circuit').datagrid('load', {
	    tvId: selectedTvId
	});
}

function openWinAddControlCircuit() {
	$('#win_add_control_circuit').window('open');
}

function openWinDelControlCircuit() {
	$('#win_del_control_circuit').window('open');
}

function submitWinAddControlCircuit() {
	$('#win_add_control_circuit').window('close');
	$("#form_add_control_circuit_tvId").val(selectedTvId);
	$('#form_add_control_circuit').form('submit');
}

function clearWinAddControlCircuit() {
	$('#form_add_control_circuit').form('clear');
}

function cancelWinAddControlCircuit() {
	$('#form_add_control_circuit').form('clear');
	$('#win_add_control_circuit').window('close');
}

/**
 * load DRC deck by tvId
 * @param selectedTvId
 */
function loadDrcDeckListByTv(selectedTvId) {
	$('#grid_tv_drc_deck').datagrid('load', {
	    tvId: selectedTvId
	});
}

function openWinAddDrcDeck() {
	$('#win_add_drc_deck').window('open');
}

function openWinDelDrcDeck() {
	$('#win_del_drc_deck').window('open');
}

function submitWinAddDrcDeck() {
	$('#win_add_drc_deck').window('close');
	$("#form_add_drc_deck_tvId").val(selectedTvId);
	$('#form_add_drc_deck').form('submit');
}

function clearWinAddDrcDeck() {
	$('#form_add_drc_deck').form('clear');
}

function cancelWinAddDrcDeck() {
	$('#form_add_drc_deck').form('clear');
	$('#win_add_drc_deck').window('close');
}

/**
 * load LVS deck by tvId
 * @param selectedTvId
 */
function loadLvsDeckListByTv(selectedTvId) {
	$('#grid_tv_lvs_deck').datagrid('load', {
	    tvId: selectedTvId
	});
}

function openWinAddLvsDeck() {
	$('#win_add_lvs_deck').window('open');
}

function openWinDelLvsDeck() {
	$('#win_del_lvs_deck').window('open');
}

function submitWinAddLvsDeck() {
	$('#win_add_lvs_deck').window('close');
	$("#form_add_lvs_deck_tvId").val(selectedTvId);
	$('#form_add_lvs_deck').form('submit');
}

function clearWinAddLvsDeck() {
	$('#form_add_lvs_deck').form('clear');
}

function cancelWinAddLvsDeck() {
	$('#form_add_lvs_deck').form('clear');
	$('#win_add_lvs_deck').window('close');
}

/**
 * load RC deck by tvId
 * @param selectedTvId
 */
function loadRcDeckListByTv(selectedTvId) {
	$('#grid_tv_rc_deck').datagrid('load', {
	    tvId: selectedTvId
	});
}

function openWinAddRcDeck() {
	$('#win_add_rc_deck').window('open');
}

function openWinDelRcDeck() {
	$('#win_del_rc_deck').window('open');
}

function submitWinAddRcDeck() {
	$('#win_add_rc_deck').window('close');
	$("#form_add_rc_deck_tvId").val(selectedTvId);
	$('#form_add_rc_deck').form('submit');
}

function clearWinAddRcDeck() {
	$('#form_add_rc_deck').form('clear');
}

function cancelWinAddRcDeck() {
	$('#form_add_rc_deck').form('clear');
	$('#win_add_rc_deck').window('close');
}


/**
 * load SPICE model by tvId
 * @param selectedTvId
 */
function loadSpiceModelListByTv(selectedTvId) {
	$('#grid_tv_spice_model').datagrid('load', {
	    tvId: selectedTvId
	});
}

function openWinDelSpiceModel() {
	$('#win_del_spice_model').window('open');
}

function openWinAddSpiceModel() {
	$('#win_add_spice_model').window('open');
}

function submitWinAddSpiceModel() {
	$('#win_add_spice_model').window('close');
	$("#form_add_spice_model_tvId").val(selectedTvId);
	$('#form_add_spice_model').form('submit');
}

function clearWinAddSpiceModel() {
	$('#form_add_spice_model').form('clear');
}

function cancelWinAddSpiceModel() {
	$('#form_add_spice_model').form('clear');
	$('#win_add_spice_model').window('close');
}



/* */
var tb_my_jobs = [{
    text:'Add',
    iconCls:'icon-add',
    handler:function(){alert('add')}
},{
    text:'Delete',
    iconCls:'icon-remove',
    handler:function(){alert('delete')}
},'-',{
    text:'Test Vehicle',
    handler:function(){alert('tv')}
}];



// initialize
function initAllForms() {
	// new job form
	$('#form_add_job').form({
	    url:'./ws/rs/job/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_job').dialog('open');
	    },
	    success:function(data){
	    	$('#pg_submit_add_job').progressbar('setValue', 50);
	    	$('#pg_submit_add_job').progressbar('setValue', 99);
	    	$('#dialog_submit_add_job').dialog('close');
	    	//$('#tb_job_list').tree('reload');
	    	loadJobList();
	    	
	    	// switch back to job list tab
	    	$('#acme_tab').tabs('select', 'Job List');
	    }
	});
	
	// TV tree
	$('#tree_tv_list').tree({
		onClick: function(node){
			var nodeId = node.id;
			var nodeIdArray = nodeId.split(":");
			selectedTvId = nodeIdArray[0];

			if (undefined == selectedTvId) {
				alert("Unknown TV Id!");
			} else {
				if (undefined == nodeIdArray[1]) {
					$("#tb_maintain_vehicle").tabs('select', 'Define Control Circuit');
					loadControlCircuitListByTv(selectedTvId);
				} else if (nodeIdArray[1] == "CC") {
					$("#tb_maintain_vehicle").tabs('select', 'Define Control Circuit');
					loadControlCircuitListByTv(selectedTvId);
				} else if (nodeIdArray[1] == "DRC") {
					$("#tb_maintain_vehicle").tabs('select', 'Define DRC Deck');
					loadDrcDeckListByTv(selectedTvId);
				} else if (nodeIdArray[1] == "LVS") {
					$("#tb_maintain_vehicle").tabs('select', 'Define LVS Deck');
					loadLvsDeckListByTv(selectedTvId);
				} else if (nodeIdArray[1] == "RC") {
					$("#tb_maintain_vehicle").tabs('select', 'Define RC Deck');
					loadRcDeckListByTv(selectedTvId);
				} else if (nodeIdArray[1] == "SPICE") {
					$("#tb_maintain_vehicle").tabs('select', 'Define SPICE Model');
					loadSpiceModelListByTv(selectedTvId);
				}
			}
			
		}
	});
	
	// add new vehicle
	$('#form_add_vehicle').form({
	    url:'./ws/rs/project/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_vehicle').dialog('open');
	    },
	    success:function(data){
	    	$('#dialog_submit_add_vehicle').dialog('close');
	    	 $('#tree_tv_list').tree('reload');
	    }
	});
	
	// add new control circuit
	$('#form_add_control_circuit').form({
	    url:'./ws/rs/project/control_circuit/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_control_circuit').dialog('open');
	    },
	    success:function(data){
	    	$('#dialog_submit_add_control_circuit').dialog('close');
	    	$('#grid_tv_control_circuit').datagrid('reload',{
	    		tvId: selectedTvId
	    	});
	    }
	});
	
	// add new DRC deck
	$('#form_add_drc_deck').form({
	    url:'./ws/rs/project/drc_deck/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_drc_deck').dialog('open');
	    },
	    success:function(data){
	    	$('#dialog_submit_add_drc_deck').dialog('close');
	    	$('#grid_tv_drc_deck').datagrid('reload',{
	    		tvId: selectedTvId
	    	});
	    }
	});
	
	// LVS deck
	$('#form_add_lvs_deck').form({
	    url:'./ws/rs/project/lvs_deck/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_lvs_deck').dialog('open');
	    },
	    success:function(data){
	    	$('#dialog_submit_add_lvs_deck').dialog('close');
	    	$('#grid_tv_lvs_deck').datagrid('reload',{
	    		tvId: selectedTvId
	    	});
	    }
	});
	
	// RC deck
	$('#form_add_rc_deck').form({
	    url:'./ws/rs/project/rc_deck/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_rc_deck').dialog('open');
	    },
	    success:function(data){
	    	$('#dialog_submit_add_rc_deck').dialog('close');
	    	$('#grid_tv_rc_deck').datagrid('reload',{
	    		tvId: selectedTvId
	    	});
	    }
	});
	
	// SPICE model
	$('#form_add_spice_model').form({
	    url:'./ws/rs/project/spice_model/new',
	    onSubmit: function(){
	        // do some check
	        // return false to prevent submit;
	    	$('#dialog_submit_add_spice_model').dialog('open');
	    },
	    success:function(data){
	    	$('#dialog_submit_add_spice_model').dialog('close');
	    	$('#grid_tv_spice_model').datagrid('reload',{
	    		tvId: selectedTvId
	    	});
	    }
	});
	
	
	// select job summary tab
	$('#job_stage_tab').tabs('select', 'Input GDS');
	
	$('#job_stage_tab').tabs({
		onSelect: function(title,index) {
			$('#job_flow_gds_info').css('background-color', 'rgba(255,255,255,0.01)');
			$('#job_flow_drc_result').css('background-color', 'rgba(255,255,255,0.01)');
			$('#job_flow_lvs_result').css('background-color', 'rgba(255,255,255,0.01)');
			$('#job_flow_rc_result').css('background-color', 'rgba(255,255,255,0.01)');
			$('#job_flow_spice_result').css('background-color', 'rgba(255,255,255,0.01)');

			switch(index) {
		    case 0:
		    	$('#job_flow_gds_info').css('background-color', 'rgba(155,255,255,0.3)');
		        break;
		    case 1:
		    	$('#job_flow_drc_result').css('background-color', 'rgba(155,255,255,0.3)');
		        break;
		    case 2:
		    	$('#job_flow_lvs_result').css('background-color', 'rgba(155,255,255,0.3)');
		    	break;
		    case 3:
		    	$('#job_flow_rc_result').css('background-color', 'rgba(155,255,255,0.3)');
		    	break;
		    case 4:
		    	$('#job_flow_spice_result').css('background-color', 'rgba(155,255,255,0.3)');
		    	break;
		    default:
		        // default
			}
		}
	});
	
}