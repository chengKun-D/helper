<template>
  <div>
    <el-table
      :data="epidemicData"
      stripe
      height="500"
      highlight-current-row
      empty-text="暂无数据"
    >
      <el-table-column
        label="城市（区）"
        prop="city"
        align="center"
      ></el-table-column>
      <el-table-column
        label="本土新增确诊"
        prop="newDiagnosed"
        align="center"
      ></el-table-column>
      <el-table-column
        label="本土新增无症状"
        prop="newAsymptomatic"
        align="center"
      ></el-table-column>
      <el-table-column
        label="现有确诊"
        prop="diagnosed"
        align="center"
      ></el-table-column>
      <el-table-column
        label="中高风险地区"
        prop="mediumAndHighRiskAreas"
        align="center"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";

const epidemicData = ref([
  {
    city: "大连",
    newDiagnosed: 5,
    newAsymptomatic: 101,
    diagnosed: null,
    mediumAndHighRiskAreas: null,
  },
  {
    city: "济南",
    newDiagnosed: null,
    newAsymptomatic: null,
    diagnosed: null,
    mediumAndHighRiskAreas: null,
  },
  {
    city: "聊城",
    newDiagnosed: null,
    newAsymptomatic: null,
    diagnosed: null,
    mediumAndHighRiskAreas: null,
  },
]);
</script>

<style lang="css" scoped></style>
