<%@ tag body-content="scriptless" %>
<%@ attribute name="name" required="true" %>

<jsp:doBody var="message" />

${message}, ${name}!
