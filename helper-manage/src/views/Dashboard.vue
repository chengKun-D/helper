<template>
  <div id="myChart" class="myChart" style="width: 800px; height: 400px"></div>
</template>

<script lang="ts" setup>
import * as echarts from "echarts";
import { onMounted } from "vue";

type EChartsOption = echarts.EChartsOption;

onMounted(() => {
  var chartDom = document.getElementById("myChart")!;
  var myChart = echarts.init(chartDom);
  option && myChart.setOption(option);
});

var option: EChartsOption;

option = {
  title: {
    text: "大连疫情数据",
  },
  tooltip: {
    trigger: "axis",
  },
  legend: {
    data: ["新增确诊","新增无症状","总计"],
  },
  grid: {
    left: "3%",
    right: "4%",
    bottom: "3%",
    containLabel: true,
  },
  toolbox: {
    feature: {
      saveAsImage: {},
    },
  },
  xAxis: {
    type: "category",
    boundaryGap: false,
    data: ["9-1", "9-2", "9-3", "9-4", "9-5", "9-6", "9-7","9-8","9-9","9-10","9-11","9-12","9-13","9-14","9-15","9-16","9-17",],
  },
  yAxis: {
    type: "value",
  },
  series: [
    {
      name: "新增确诊",
      type: "line",
      stack: "Total",
      data: [4,3,6,5,9,2,2,3,2,3],
    },
    {
      name: "新增无症状",
      type: "line",
      stack: "Total",
      data: [101,112,106,101,86,85,76,70,75,53]
    },
    {
      name: "总计",
      type: "line",
      stack: "Total",
      data:[4+101,3+112,6+106,5+101,9+86,2+85,2+76,3+70,2+75,3+53]
    }
  ],
};
</script>

<style lang="css" scoped></style>
