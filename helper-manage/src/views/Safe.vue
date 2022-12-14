<template>
  <el-button type="primary" @click="handleAdd"> 新增 </el-button>
  <div>
    <el-table
      :data="filterTableData"
      height="500"
      stripe
      empty-text="暂无数据"
      highlight-current-row
    >
      <el-table-column prop="account" label="账号"></el-table-column>
      <el-table-column
        prop="password"
        label="密码"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="remark"
        label="备注"
        align="center"
      ></el-table-column>
      <el-table-column align="right">
        <template #header>
          <el-input
            v-model="search"
            size="small"
            placeholder="根据备注信息过滤数据"
            clearable
          />
        </template>
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
  <el-dialog
    v-model="isDialogShow"
    center
    draggable
    width="30%"
    :show-close="false"
  >
    <template #header> {{ dialogTitle }} </template>
    <el-form
      :model="additionalData"
      :label-position="labelPosition"
      label-width="100px"
      ref="additionalDataRef"
    >
      <el-form-item label="账 号：" prop="account">
        <el-input v-model="additionalData.account"></el-input>
      </el-form-item>
      <el-form-item label="密 码：" prop="password">
        <el-input v-model="additionalData.password"></el-input>
      </el-form-item>
      <el-form-item label="备注信息：" prop="remark">
        <el-input v-model="additionalData.remark"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button type="primary" @click="handleConfirm"> 确认 </el-button>
      <el-button type="danger" @click="handleCancel"> 取消 </el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { ElMessage, ElMessageBox, FormInstance } from "element-plus";
import { computed, ref, reactive, nextTick, inject } from "vue";
import type { Action } from "element-plus";
import { addData, editData, getData, deleteData } from "../api/safe";

const labelPosition = ref("left");
const isDialogShow = ref(false);
const search = ref();
const dialogTitle = ref();
const additionalDataRef = ref<FormInstance>();
const reload: any = inject("reload");
/* 编辑或新增数据弹出的对话框数据 */
const additionalData = reactive({
  id: "",
  account: "",
  password: "",
  remark: "",
});
/* 表格数据 */
const tableData = reactive<Array<Object>>([]);
/* 根据remark过滤数据 */
const filterTableData = computed(() =>
  tableData.filter(
    (data: any) =>
      !search.value ||
      data.remark.toLowerCase().includes(search.value.toLowerCase())
  )
);
/* 编辑某一行 */
const handleEdit = (index: number, row: any) => {
  dialogTitle.value = "编辑";
  isDialogShow.value = true;
  nextTick(() => {
    additionalData.id = row.id;
    additionalData.account = row.account;
    additionalData.password = row.password;
    additionalData.remark = row.remark;
  });
};
/* 取消修改或取消新增 */
const handleCancel = () => {
  nextTick(() => {
    additionalDataRef.value?.resetFields();
  });
  isDialogShow.value = false;
};
/* 删除一条数据 */
const handleDelete = (index: number, row: any) => {
  ElMessageBox.confirm("确定要删除嘛？", "提示", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning",
    showClose: false,
    callback: (action: Action) => {
      if (action === "confirm") {
        deleteData(row.id).then(() => {
          ElMessage({
            type: "success",
            message: "删除成功",
          });
        });
      }
      reload();
    },
  });
};
/* 新增按钮 */
const handleAdd = () => {
  dialogTitle.value = "新增";
  isDialogShow.value = true;
  nextTick(() => {
    additionalDataRef.value?.resetFields();
  });
};
/* 新增或编辑确认按钮 */
const handleConfirm = () => {
  if (dialogTitle.value == "新增") {
    addData(additionalData).then((res) => {
      ElMessage({
        message: "新增成功！",
        type: "success",
      });
    });
  } else {
    editData(additionalData).then((res) => {
      console.log(res);
      ElMessage({
        message: "修改成功！",
        type: "success",
      });
    });
    reload();
  }
  isDialogShow.value = false;
  reload();
};
/* 获取数据库数据 */
const handleGetData = () => {
  getData().then((res) => {
    res.data.forEach((element: Object) => tableData.push(element));
  });
};
handleGetData();
</script>

<style lang="css" scoped></style>
