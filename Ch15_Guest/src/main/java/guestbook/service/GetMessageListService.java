package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.jdbcUtil;
import jdbc.connection.ConnectionProvider;


//P.457
public class GetMessageListService {
	
	//Singleton
	private static GetMessageListService instance = new GetMessageListService();

	public static GetMessageListService getInstance() {
		return instance;
	}

	private GetMessageListService() {
	}

	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MessageListView getMessageList(int pageNumber) {
		Connection conn = null;
		int currentPageNumber = pageNumber;
		try {
			conn = ConnectionProvider.getConnection(); //객체생성
			MessageDao messageDao = MessageDao.getInstance(); //객체생성
			
			int messageTotalCount = messageDao.selectCount(conn);
			
			List<Message> messagesList = null;
			int firstRow = 0;
			int endRow = 0;
			if(messageTotalCount>0) {
				firstRow = (pageNumber-1)*MESSAGE_COUNT_PER_PAGE+1;
				endRow = firstRow+MESSAGE_COUNT_PER_PAGE-1;
				messagesList = messageDao.selectList(conn, firstRow, endRow);
			}else {
				currentPageNumber = 0;
				messagesList = Collections.emptyList();
			}
			return new MessageListView(messagesList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
		} catch(SQLException e) {
			throw new ServiceException("목록 구하기 실패:" +e.getMessage(), e);
		}finally {
			jdbcUtil.close(conn);
		}
	}
}
