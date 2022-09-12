import service from "../utils/request";

export function addData(data: any) {
  return service({
    url: "/safe/add",
    method: "post",
    data: data,
  });
}

export function editData(data: any) {
  return service({
    url: "/safe/edit",
    method: "post",
    data: data,
  });
}
