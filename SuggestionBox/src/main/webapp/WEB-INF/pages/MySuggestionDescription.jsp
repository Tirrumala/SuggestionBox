<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="userProfileDetailsBean"
	class="com.opensource.suggestionbox.beans.modelview.UserProfileDetailsBean"
	scope="session" />
<jsp:setProperty name="userProfileDetailsBean" property="*" />

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Suggestions</title>
<link href="static/css/tabs.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="static/js/MySuggestionDescription.js"></script>
</head>
<body>
	<jsp:include page="SuggestionBoxHeader.jsp" />
	<br>
	<hr style="border: #48f solid 3px">

	<jsp:include page="PrivilegesMenu.jsp">
		<jsp:param name="menu" value="MySuggestion" />
	</jsp:include>

	<hr style="border: #48f solid 3px">

	<jsp:include page="MySuggestionHeader.jsp" />

	<div id="myspaceSuggestionId">
		<br>
		<div align="justify">
			<table>
				<tr>
					<td>
						<h3 style="color: red;">${suggestionDescriptionBean.getSuggestionDescriptionList().get(0).getSgId()}:</h3>
					</td>
					<td>
						<h3>${suggestionTitle}</h3>
					</td>
				</tr>
			</table>
		</div>

		<div align="left" style="height: 40px;">
			<table id="myspaceSuggestionListTableHeaderId" >
				<tr>
					<td style="height: 30px;"><input type="image"
						id="myspaceImageTableHeaderDeleteId"
						style="height: 25px; width: 25px;" src="static/icons/Delete.png"
						onclick="mySugDelete();" />
						</td>
						<td style="width: 200px;">
							<label for="myspaceImageTableHeaderDeleteId">Delete
								suggestion</label>
						</td>
				</tr>
			</table>
		</div>

		<div id="myspaceSuggestionAppendId">

			<c:forEach
				items="${suggestionDescriptionBean.getSuggestionDescriptionList()}"
				var="suggestionDescriptionVar">

				<div id="myspaceSuggestionDescId1"
					style="background-color: lightblue">
					<table id="myspaceSuggestionListTableId">
						<tr style="height: 20px;">

							<td align="left" style="width: 30px;"><c:choose>
									<c:when
										test="${userProfileDetailsBean.getUserName().equals(suggestionDescriptionVar.getUser())}">
										<input type="image" id="myspaceImageListId"
											style="height: 20px; width: 20px;"
											src="static/icons/Edit_Small.png"
											onclick="editDescription('EDIT','${suggestionDescriptionVar.getUuid()}','${suggestionDescriptionVar.getDescription()}')">
									</c:when>
									<c:otherwise>
										<input type="image" id="myspaceImageListId"
											style="height: 20px; width: 20px;"
											src="static/icons/Edit_Small.png" disabled="disabled" />
									</c:otherwise>
								</c:choose></td>

							<td align="center" style="width: 30px;"><c:choose>
									<c:when test="${suggestionDescriptionVar.getIsLiked() == '0'}">
										<img style="height: 20px; width: 20px;"
											src="static/icons/Like.png" />
									</c:when>
									<c:otherwise>
										<img style="height: 20px; width: 20px;"
											src="static/icons/Dislike.png" />
									</c:otherwise>
								</c:choose></td>

							<td align="center" style="width: 100px;"><label>User
									:</label></td>
							<td align="center" style="width: 250px;"><label>${suggestionDescriptionVar.getUser()}</label></td>

							<td align="center" style="width: 150px;"><label>Updated
									On :</label></td>

							<td align="center" style="width: 150px;"><label>${suggestionDescriptionVar.getUpdatedOn()}</label></td>

							<td align="right" style="width: 150px;"><a
								href="Attachment?fileName=${suggestionDescriptionVar.getFileName()}&fileUuid=${suggestionDescriptionVar.getFileUuid()}">${suggestionDescriptionVar.getFileName()}</a>
							</td>

						</tr>
					</table>
				</div>

				<div align="left" id="myspaceSuggestionDescId"
					style=" min-height: 100px; background-color: lightyellow">
					${suggestionDescriptionVar.getDescription()}</div>

			</c:forEach>
		</div>

	</div>

	<hr style="border: solid 3px">
	<div id="mySpaceCommentBoxId" align="center">
		<form:form action="MySuggestionDescription" method="post"
			commandname="suggestionDescriptionUIBean"
			modelAttribute="suggestionDescriptionUIBean"
			enctype="multipart/form-data">
			<h2>Add your Comments:</h2>
			<table>

				<tr>
					<td align="left" style="width: 100px;"><label>Suggestion</label></td>
					<td><textarea name="mySpaceTextAreaName"
							id="mySpaceTextAreaId" rows="10" cols="70" style="resize: none"></textarea></td>
					<td></td>
				</tr>

				<tr>
					<td align="left" style="width: 100px;"><label>Attachment</label></td>
					<td><form:input type="file" path="fileUpload.fileUpload"
							id="myspaceDescAttachId" name="myspaceDescAttach" /></td>
					<td></td>
				</tr>

				<tr align="center" height="50px">
					<td></td>
					<td align="left"><label><form:checkbox path="visiblePublic"
								 /> Yes, Attachment can be visible to all</label></td>
					<td></td>
				</tr>
				<tr align="center" height="50px">
					<td></td>
					<td align="left"><label><form:checkbox path="likes"
								checked="checked" />Yes, I Like the suggestion</label></td>
					<td></td>
				</tr>
				<tr align="center" height="50px">

					<td></td>
					<td align="center"><input type="submit"
						style="font-style: italic; font-size: larger; color: red"
						id="myspaceDislikesId" value="Submit" /> <input type="button"
						style="font-style: italic; font-size: larger; color: black"
						id="myspaceCancelId" value="Cancel" onclick="cancelDescription();" />
						<input type="hidden" id="myspaceSuggestionId"
						name="myspaceSuggestionName"
						value="${suggestionDescriptionBean.getSuggestionDescriptionList().get(0).getSgId()}" />
						<input type="hidden" id="myspaceSuggestionDescriptionId"
						name="myspaceSuggestionDescriptionName" value="" /></td>
					<td></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>