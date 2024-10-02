// 현재날짜시간 함수
function getCurrentDateTime() {
  // 현재 날짜 시간 구하기
  const now = new Date();

  // 년
  const year = now.getFullYear();
  // 월
  const month = (now.getMonth() + 1).toString().padStart(2, "0");
  // 일
  const day = now.getDate().toString().padStart(2, "0");
  // 시
  const hours = now.getHours().toString().padStart(2, "0");
  // 분
  const minutes = now.getMinutes().toString().padStart(2, "0");
  // 초
  const seconds = now.getSeconds().toString().padStart(2, "0");

  return year + month + day + hours + minutes + seconds;
}

// 띄어쓰기 제거함수
function removeSpaces(str) {
  return str.replace(/\s+/g, "");
}

// 띄어쓰기 Validator 함수 생성
function noWhitespaceValidator(value, args) {
  if (/\s/.test(value)) {
    return { valid: false, msg: `${args.column.name}은 띄어쓰기 금지입니다.` };
  }
  return { valid: true, msg: null };
}

// 필수여부 Validator 함수 생성
function createValidator(value, args) {
  if (value === null || value === "") {
    return { valid: false, msg: `${args.column.name}은 필수입니다.` };
  } else {
    return { valid: true, msg: null };
  }
}

// N자릿수 Validator 함수 생성
function nStrLengthValidator(value, args, len) {
  if (value.length !== len) {
    return {
      valid: false,
      msg: `${args.column.name}은 ${len}자릿수를 유지해야합니다.`,
    };
  }
  return { valid: true, msg: null };
}

// 여러개의 validator를 한번에 정의가능
function complexValidator(value, args, validators) {
  //const validators = [createValidator, noWhitespaceValidator];
  for (const validator of validators) {
    const result = validator(value, args);
    if (!result.valid) {
      return result;
    }
  }
  return { valid: true, msg: null };
}

function validateCompositeEditors(targetElm) {
  var validationResults = { valid: true, msg: "" };
  var currentEditor = grid.getCellEditor();
  if (currentEditor) {
    validationResults = currentEditor.validate(targetElm);
  }
  return validationResults;
}
// Custom ComboBox Editor
function ComboBoxEditor(args, dropdownValues) {
  var $select;
  var defaultValue;

  this.init = function () {
    $select = $("<select class='editor-combobox'>")
      .appendTo(args.container)
      .on("keydown.nav", function (e) {
        if (e.key === "Enter" || e.key === "Tab") {
          validateCompositeEditors(e.target);
        }
      });

    // Add options to the select element from passed dropdownValues
    dropdownValues.forEach(function (item) {
      $select.append(
        $("<option></option>").attr("value", item.key).text(item.value)
      );
    });

    $select.focus();
  };

  this.destroy = function () {
    $select.remove();
  };

  this.focus = function () {
    $select.focus();
  };

  this.loadValue = function (item) {
    defaultValue = item[args.column.field];
    $select.val(defaultValue);
  };

  this.serializeValue = function () {
    return $select.val();
  };

  this.applyValue = function (item, state) {
    item[args.column.field] = state;
  };

  this.isValueChanged = function () {
    return $select.val() !== defaultValue;
  };

  this.validate = function () {
    return {
      valid: true,
      msg: null,
    };
  };
  this.init();
}
// Custom Password Editor
function PasswordEditor(args) {
  var $input;
  var defaultValue;
  this.args = args;

  this.init = function () {
    $input = $("<input type='password' class='editor-text' />")
      .appendTo(args.container)
      .on("keydown.nav", function (e) {
        if (e.key === "Enter" || e.key === "Tab") {
          validateCompositeEditors(e.target);
        }
      });

    $input.focus().select();
  };

  this.destroy = function () {
    $input.remove();
  };

  this.focus = function () {
    $input.focus();
  };

  this.getValue = function () {
    return $input.val();
  };

  this.setValue = function (val) {
    $input.val(val);
  };

  this.loadValue = function (item) {
    defaultValue = item[args.column.field] || "";
    $input.val(defaultValue);
    $input[0].defaultValue = defaultValue;
    $input.select();
  };

  this.serializeValue = function () {
    return $input.val();
  };

  this.applyValue = function (item, state) {
    item[args.column.field] = state;
  };

  this.isValueChanged = function () {
    return $input.val() !== defaultValue;
  };

  this.validate = function () {
    if (args.column.validator) {
      let validationResults = args.column.validator($input.val(), args);
      if (!validationResults.valid) return validationResults;
    }
    return {
      valid: !0,
      msg: null,
    };
  };

  this.init();
}

//Select 조회 : $("#inpSearchTxt").val(), '/WRKFIL001M0SelectList'
function parentGetFile(input, url) {
  console.log("Sending AJAX request...");
  var result_data;
  $.ajax({
    type: "post",
    url: url,
    async: false,
    dataType: "json",
    contentType: "application/json; charset=utf-8",
    data: input,
    success: function (data) {
      console.log("AJAX request successful. Data received:", data);
      result_data = data;
      if (data && data.length > 0) {
        console.log("The number of Data :", data.length);
      } else {
        console.log("No data returned from the server.");
      }
    },
    error: function (xhr, status, error) {
      console.error("!!!! ERROR !!!!!", status, error);
      result_data = "fail";
    },
  });
  return result_data;
}

var ajaxRequest = null;

// Insert 함수 : '/WRKFIL001M0InsertList'
function parentInsertFile(addedRow, url) {
	if(ajaxRequest !== null){
		ajaxRequest.abort();
	}
	
ajaxRequest =  $.ajax({
    type: "post",
    url: url,
    async: true,
    dataType: "text", //서버에서 어떤 타입을 받을 것인가
    contentType: "application/json; charset=utf-8", //서버로 어떤 타입을 보낼 것인가
    data: JSON.stringify(addedRow),
    success: function (response) {
      alert("Successfully Insert");
    },
    error: function (error) {
      console.error("Error inserting data:", error);
    },
  });
}
// Update 함수 : '/WRKFIL001M0UpdateList'
function parentUpdateFile(updatedRow, url) {
	if(ajaxRequest !== null){
		ajaxRequest.abort();
	}
 ajaxRequest = $.ajax({
    type: "post",
    url: url,
    async: true,
    dataType: "text", //서버에서 어떤 타입을 받을 것인가
    contentType: "application/json; charset=utf-8", //서버로 어떤 타입을 보낼 것인가
    data: JSON.stringify(updatedRow),
    success: function (response) {
      alert("Successfully Updated");
      console.log("update 테스트js");
    },
    error: function (error) {
      console.error("Error updating data:", error);
    },
  });
}

// Delete 함수
function parentDeleteFile(todeleteRow, url) {
  $.ajax({
    type: "post",
    url: url,
    async: true,
    dataType: "text", //서버에서 어떤 타입을 받을 것인가
    contentType: "application/json; charset=utf-8", //서버로 어떤 타입을 보낼 것인가
    data: JSON.stringify(todeleteRow),
    success: function (response) {
      alert("Successfully Deleted");
    },
    error: function (error) {
      console.error("Error deleting data:", error);
    },
  });
}

function parentCheckData(data, check_cols) {
  var checkr = [];
  for (key in data) {
    if (check_cols.includes(key) && (data[key] === null || data[key] === "")) {
      checkr.push(false);
    } else {
      checkr.push(true);
    }
  }
  return checkr.every((v) => v === true);
}

function focusOnFirstCellWithEditor(columns, rowIndex, isWithMassUpdate) {
  var columnIndexWithEditor = 0;

  const hasEditor = columns[columnIndexWithEditor].editor;
  if (!hasEditor) {
    if (isWithMassUpdate) {
      columnIndexWithEditor = columns.findIndex(function (col) {
        return col.editor && col.massUpdate;
      });
    } else {
      columnIndexWithEditor = columns.findIndex(function (col) {
        return col.editor;
      });
    }
    if (columnIndexWithEditor === -1) {
      throw new Error("We could not find any Editor in your Column Definition");
    } else {
      grid.setActiveCell(rowIndex, columnIndexWithEditor, false);
      if (isWithMassUpdate) {
        // when it's a mass change, we'll activate the last row without scrolling to it
        // that is possible via the 3rd argument "suppressScrollIntoView" set to "true"
        grid.setActiveRow(data.length, columnIndexWithEditor, true);
      }
    }
  }
}

// grid options 수정 함수
function renewOptions(isEdit = true) {
  grid.setOptions({ editable: isEdit }, true, true, true);
}

// exportToExcel 함수 정의
function exportToExcel(fileNm, sheetNm = "Sheet1", columns, data) {
  // 컬럼명과 데이터 처리
  const gridData = data.map((row) => {
    const rowData = {};
    columns.forEach((column) => {
      rowData[column.name] = row[column.field];
    });
    return rowData;
  });

  // 워크시트로 변환
  const worksheet = XLSX.utils.json_to_sheet(gridData);

  // 새 워크북 생성
  const workbook = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(workbook, worksheet, sheetNm);

  // 워크북을 엑셀 파일로 작성하고 다운로드 트리거
  XLSX.writeFile(workbook, `${fileNm}.xlsx`);
}

/*===========================================
 * 입력값이 NULL이면 "" 리턴
 * @param obj   Object
 * @return true : Null 또는 공백
 ===========================================*/
function isNull(obj) {
    if (obj == null || obj == "") {
    	return "";  
    }
    return obj;
}

/*===========================================
 * 이메일 형식을 검증하는 함수
 * @param obj   Object
 * @return true : true
 ===========================================*/
function validateEmail(email) {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailPattern.test(email);
}
