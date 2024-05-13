<template>
  <i-frame :src="url" />
</template>
<script>
import iFrame from "@/components/iFrame/index";
export default {
  name: "magicApi",
  components: { iFrame },
  data() {
    return {
      url: process.env.VUE_APP_BASE_API + "/magic/web/index.html"
    };
  },
  created(){
    console.log("nihao=="+this.$route.query.paramsUrl)
  }
};
</script>
