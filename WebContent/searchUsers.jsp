<!--
Copyrights (c) 2011 Rohit Harchandani and Risha Chheda
For the complete license, please refer to the root-level license.txt document
-->

<jsp:include page="template-top.jsp" />

<jsp:include page="error-list.jsp" />

<p>
	<form method="post" action="searchUsers.do" enctype="multipart/form-data">
		<table width = "70%">
		<caption ><font size ="+2" >
		<b> Search Users:
	</b></font></caption> 
			
			<tr>
				<td align="center">Name: <input type="text" name="searchByName" value=""/></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="button" value="Search"/>
				</td>
			</tr>
		</table>
	</form>
</p>

<jsp:include page="template-bottom.jsp" />