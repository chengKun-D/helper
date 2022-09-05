<template>
  <div>
    <el-table
      :data="filterTableData"
      height="500"
      stripe
      empty-text="暂无数据"
      highlight-current-row
    >
      <el-table-column
        prop="account"
        label="账号"
        
      ></el-table-column>
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
          <el-button size="small" type="danger" @click="handleDelete"
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
    <template #header> 编辑 </template>
    <el-form
      :model="additionalData"
      :label-position="labelPosition"
      label-width="100px"
    >
      <el-form-item label="账 号：">
        <el-input v-model="additionalData.account"></el-input>
      </el-form-item>
      <el-form-item label="密 码：">
        <el-input v-model="additionalData.password"></el-input>
      </el-form-item>
      <el-form-item label="备注信息：">
        <el-input v-model="additionalData.remark"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button type="primary"> 确认 </el-button>
      <el-button type="danger" @click="handleCancel"> 取消 </el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { ElMessage, ElMessageBox } from "element-plus";
import { computed, ref, reactive } from "vue";
import type { Action } from "element-plus";

const labelPosition = ref("left");
const isDialogShow = ref(false);
const search = ref();
/* 编辑或新增数据弹出的对话框数据 */
const additionalData = reactive({
  account: "",
  password: "",
  remark: "",
});
/* 表格数据 */
const tableData = reactive([
  {
    account: "1234",
    password: "11111",
    remark: "remark",
  },
  {
    account: "ceshi",
    password: "222",
    remark: "ceshi",
  },
]);
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
  isDialogShow.value = true;
  additionalData.account = row.account;
  additionalData.password = row.password;
  additionalData.remark = row.remark;
};
/* 取消修改或取消新增 */
const handleCancel = () => {
  additionalData.account = "";
  additionalData.password = "";
  additionalData.remark = "";
  isDialogShow.value = false;
};
/* 删除一条数据 */
const handleDelete = () => {
  ElMessageBox.confirm("确定要删除嘛？", "提示", {
    confirmButtonText: "确定",
    cancelButtonText:"取消",
    type: "warning",
    showClose:false,
    callback: (action: Action) => {
      if (action === "confirm") {
        ElMessage({
          type: "success",
          message: `action: ${action}`,
        });
      }
    },
  });
};
</script>

<style lang="css" scoped></style>
