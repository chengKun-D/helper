import service from "../utils/request";
/* 
  查询数据
*/
export function getData() {
  return service({
    url: "/safe/get",
    method: "get",
  });
}

/* 
  新增数据
*/
export function addData(data: any) {
  return service({
    url: "/safe/add",
    method: "post",
    data: data,
  });
}

/* 
  编辑数据
*/
export function editData(data: any) {
  return service({
    url: "/safe/edit",
    method: "post",
    data: data,
  });
}

/* 
  删除数据
*/
export function deleteData(data: any) {
  return service({
    url: "/safe/delete",
    method: "delete",
    data: data,
  });
}
