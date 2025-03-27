 function confirmDelete(button) {
    const boardId = button.getAttribute('data-id');
    if (confirm("정말 삭제하시겠습니까?")) {
      location.href = '/board/boarddelete/' + boardId;
    }
    }

  function confirmUpdate1(button) {  <!--이건 get로 수정하기-->
    const boardId = button.getAttribute('data-id');
    const boardTitle = button.getAttribute('data-title');
    const boardContent = button.getAttribute('data-content');
    if (confirm("정말 수정하시겠습니까?")) {
      location.href = '/board/boardupdate/' + boardId;
  }
  }

 function confirmUpdate(button) {
    if (confirm("정말 수정하시겠습니까?")) {
      document.getElementById("updateForm").submit();
  }
  }