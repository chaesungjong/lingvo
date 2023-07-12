<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="px-4 py-5 my-5 text-center">
    <div class="col-lg-6 mx-auto">
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
        <button type="button" class="btn btn-primary btn-lg px-4 gap-3" id="save">안전합니다.</button>
        <button type="button" class="btn btn-outline-secondary btn-lg px-4" id="review">개선이 필요합니다.</button>
      </div>
    </div>
  </div>
  <script>
    $("#save").click(function() {
        location.href = "/work/workReviewEnd";
    });
    $("#review").click(function() {
        location.href = "/work/workImprovementReview";
    });
</script>