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
    text: "疫情数据",
  },
  tooltip: {
    trigger: "axis",
  },
  legend: {
    data: ["大连", "济南", "聊城"],
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
    data: ["9-1", "9-2", "9-3", "9-4", "9-5", "9-6", "9-7"],
  },
  yAxis: {
    type: "value",
  },
  series: [
    {
      name: "大连",
      type: "line",
      stack: "Total",
      data: [1, 2, 2, 3, 4, 5, 5],
    },
    {
      name: "济南",
      type: "line",
      stack: "Total",
      data: [3, 4, 78, 7, 67, 7, 7],
    },
    {
      name: "聊城",
      type: "line",
      stack: "Total",
      data: [2, 6, 6, 6, 87, 7, 8],
    },
  ],
};
</script>

<style lang="css" scoped></style>
